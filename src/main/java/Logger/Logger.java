package Logger;

 public final class Logger {
     private Logger(){
     }

     public static void log(String message,LogginingLevel level) {
         if (level == LogginingLevel.WARN) {
             System.out.println(ConsoleColors.YELLOW+message+ConsoleColors.RESET);
             return;
         }
         if (level == LogginingLevel.ERROR) {
             System.out.println(ConsoleColors.RED + message + ConsoleColors.RESET);
             return;
         }
         System.out.println(message);
     }
 }
