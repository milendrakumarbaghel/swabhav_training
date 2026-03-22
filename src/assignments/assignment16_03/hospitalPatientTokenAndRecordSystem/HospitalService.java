package assignments.assignment16_03.hospitalPatientTokenAndRecordSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class HospitalService {
    private final Set<Patient> patientRecords = new HashSet<>();
    private final Map<Integer, Patient> patientById = new HashMap<>();
    private final Map<String, List<Patient>> doctorWisePatients = new HashMap<>();
    private final Map<String, List<Patient>> departmentWisePatients = new HashMap<>();
    private final Map<String, String> doctorDepartmentMap = new HashMap<>();
    private final PriorityQueue<ConsultationToken> consultationQueue = new PriorityQueue<>();
    private final Set<Integer> queuedPatientIds = new HashSet<>();

    private int nextTokenNumber = 1;

    public void registerDoctor(String doctorName, String department) throws InvalidDataException {
        if(doctorName == null || doctorName.trim().isEmpty()) {
            throw new InvalidDataException("Doctor name cannot be empty.");
        }
        if(department == null || department.trim().isEmpty()) {
            throw new InvalidDataException("Department cannot be empty.");
        }

        String doctor = doctorName.trim();
        String dept = department.trim();
        String existingDept = doctorDepartmentMap.get(doctor);

        if(existingDept != null && !existingDept.equalsIgnoreCase(dept)) {
            throw new InvalidDataException("Doctor is already mapped to department: " + existingDept);
        }

        doctorDepartmentMap.put(doctor, dept);
    }

    public void registerPatient(Patient patient) throws DuplicatePatientException, InvalidDataException {
        if(patient == null) {
            throw new InvalidDataException("Patient cannot be null.");
        }

        validateDoctorDepartmentForPatient(patient);

        if(!patientRecords.add(patient)) {
            throw new DuplicatePatientException("Duplicate patient ID is not allowed.");
        }

        patientById.put(patient.getPatientId(), patient);
        doctorWisePatients.computeIfAbsent(patient.getDoctorName(), key -> new ArrayList<>()).add(patient);
        departmentWisePatients.computeIfAbsent(patient.getDepartment(), key -> new ArrayList<>()).add(patient);
    }

    public ConsultationToken issueToken(int patientId) throws InvalidDataException {
        Patient patient = patientById.get(patientId);
        if(patient == null) {
            throw new InvalidDataException("Patient not found.");
        }
        if(patient.isDischarged()) {
            throw new InvalidDataException("Token cannot be issued for discharged patient.");
        }
        if(queuedPatientIds.contains(patientId)) {
            throw new InvalidDataException("Patient already has a pending token.");
        }

        ConsultationToken token = new ConsultationToken(
                nextTokenNumber++,
                patient.getPatientId(),
                patient.getName(),
                patient.getDepartment(),
                patient.getDoctorName(),
                patient instanceof EmergencyPatient
        );

        consultationQueue.offer(token);
        queuedPatientIds.add(patientId);
        return token;
    }

    public ConsultationToken processNextConsultation() throws InvalidDataException {
        if(consultationQueue.isEmpty()) {
            throw new InvalidDataException("No patients in consultation queue.");
        }

        ConsultationToken token = consultationQueue.poll();
        queuedPatientIds.remove(token.getPatientId());
        return token;
    }

    public void markPatientDischarged(int patientId) throws InvalidDataException {
        Patient patient = patientById.get(patientId);
        if(patient == null) {
            throw new InvalidDataException("Patient not found.");
        }
        if(patient.isDischarged()) {
            throw new InvalidDataException("Patient already marked discharged.");
        }

        patient.markDischarged();
    }

    public int removeDischargedPatients() {
        int removedCount = 0;

        Iterator<Patient> iterator = patientRecords.iterator();
        while(iterator.hasNext()) {
            Patient patient = iterator.next();
            if(patient.isDischarged()) {
                iterator.remove();
                removedCount++;

                patientById.remove(patient.getPatientId());
                queuedPatientIds.remove(patient.getPatientId());
                removeFromQueue(patient.getPatientId());
                removeFromMapList(doctorWisePatients, patient.getDoctorName(), patient.getPatientId());
                removeFromMapList(departmentWisePatients, patient.getDepartment(), patient.getPatientId());
            }
        }

        return removedCount;
    }

    public List<Patient> getPatientsSortedById() {
        List<Patient> list = new ArrayList<>(patientRecords);
        list.sort(Comparator.naturalOrder());
        return list;
    }

    public List<Patient> getPatientsSortedByName() {
        List<Patient> list = new ArrayList<>(patientRecords);
        list.sort(Comparator.comparing(Patient::getName));
        return list;
    }

    public List<Patient> getPatientsSortedByAgeDesc() {
        List<Patient> list = new ArrayList<>(patientRecords);
        list.sort(Comparator.comparingInt(Patient::getAge).reversed());
        return list;
    }

    public List<ConsultationToken> getQueueSnapshot() {
        List<ConsultationToken> list = new ArrayList<>(consultationQueue);
        list.sort(Comparator.naturalOrder());
        return list;
    }

    public Map<String, List<Patient>> getDoctorWisePatients() {
        return cloneMapOfLists(doctorWisePatients);
    }

    public Map<String, List<Patient>> getDepartmentWisePatients() {
        return cloneMapOfLists(departmentWisePatients);
    }

    public Map<String, String> getDoctorDepartmentMap() {
        return new HashMap<>(doctorDepartmentMap);
    }

    private Map<String, List<Patient>> cloneMapOfLists(Map<String, List<Patient>> source) {
        Map<String, List<Patient>> copy = new HashMap<>();
        source.forEach((key, value) -> copy.put(key, new ArrayList<>(value)));
        return copy;
    }

    private void removeFromQueue(int patientId) {
        Iterator<ConsultationToken> iterator = consultationQueue.iterator();
        while(iterator.hasNext()) {
            ConsultationToken token = iterator.next();
            if(token.getPatientId() == patientId) {
                iterator.remove();
            }
        }
    }

    private void removeFromMapList(Map<String, List<Patient>> map, String key, int patientId) {
        List<Patient> patients = map.get(key);
        if(patients == null) {
            return;
        }

        Iterator<Patient> iterator = patients.iterator();
        while(iterator.hasNext()) {
            if(iterator.next().getPatientId() == patientId) {
                iterator.remove();
            }
        }

        if(patients.isEmpty()) {
            map.remove(key);
        }
    }

    private void validateDoctorDepartmentForPatient(Patient patient) throws InvalidDataException {
        String doctor = patient.getDoctorName();
        String department = patient.getDepartment();
        String mappedDepartment = doctorDepartmentMap.get(doctor);

        if(mappedDepartment == null) {
            doctorDepartmentMap.put(doctor, department);
            return;
        }

        if(!mappedDepartment.equalsIgnoreCase(department)) {
            throw new InvalidDataException("Doctor belongs to department " + mappedDepartment + ", not " + department + ".");
        }
    }
}

