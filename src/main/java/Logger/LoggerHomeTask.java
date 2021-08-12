package Logger;


public class LoggerHomeTask {
    public static void main(String[] args) {
      Logger.log("Warm message ", LogginingLevel.WARN);
        Logger.log("Error message ", LogginingLevel.ERROR);
        Logger.log("Info message ", LogginingLevel.INFO);
        Logger.log("Debug message ", LogginingLevel.DEBUG);
    }
}
