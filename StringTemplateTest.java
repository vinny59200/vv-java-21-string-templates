import static java.lang.StringTemplate.STR;

public class StringTemplateTest {

    public static void main( String[] args ) {
        //STR basic
        String name = "Joan";
        String strBasic = STR. "My name is \{name}";
        System.out.println( "STR basic :" + strBasic );

        //STR calculation
        int x = 10, y = 20;
        String strCalculation = STR. "\{x} + \{y} = \{x + y}";
        System.out.println( "STR calculation :" + strCalculation );

        //STR with method call
        String strCall = STR. "You have a \{getOfferType()} waiting for you!";
        System.out.println( "STR with method call :" + strCall );

        //STR with object fields
        record Req(String date, String time, String ipAddress) {
        }
        ;
        Req req = new Req( "2023-07-08", "10:30:45", "192.168.0.1" );
        String strFields = STR. "Access at \{req.date} \{req.time} from \{req.ipAddress}";
        System.out.println( "STR with object fields :" + strFields );

        //        //STR multi-lines
        //        String strMultilines = STR."The time is \{
        //        // The java.time.format package is very useful
        //        DateTimeFormatter
        //                .ofPattern("HH:mm:ss")
        //                .format( LocalTime.now() )
        //        } right now";
        //        System.out.println("STR multi-lines :" + strMultilines);

        //STR html textblock
        String title = "Java 21 demo Page";
        String text = "Hello Vinny";
        String strTextBlock = STR. """
                <html>
                  <head>
                    <title>\{title}</title>
                  </head>
                  <body>
                    <p>\{text}</p>
                  </body>
                </html>
                """;
        System.out.println( "STR html textblock :" + strTextBlock );

        //STR json textblock
        String firstname = "Vinny";
        String email = "vvauban@gmx.us";
        String city = "Lille";
        String json = STR. """
                {
                    "name":    "\{firstname}",
                    "email":   "\{email}",
                    "city":    "\{city}"
                };
                """;
        System.out.println( "STR json textblock:" + json );
    }

    private static String getOfferType() {
        return "gift";
    }
}
