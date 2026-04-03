package solidPrinciple.singleResponsibilityPrinciple.q3;

public class DeviceController {
    private DeviceService deviceService;
    private LoggingService loggingService;
    private ExternalApiService apiService;
    private AlertService alertService;

    public DeviceController(DeviceService deviceService,
                            LoggingService loggingService,
                            ExternalApiService apiService,
                            AlertService alertService) {
        this.deviceService = deviceService;
        this.loggingService = loggingService;
        this.apiService = apiService;
        this.alertService = alertService;
    }

    public void execute() {
        deviceService.configure();
        loggingService.log("Device configured");
        apiService.call();
        alertService.sendAlert("Device updated");
    }
}
