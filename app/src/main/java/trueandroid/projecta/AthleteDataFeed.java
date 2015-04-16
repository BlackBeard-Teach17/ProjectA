package trueandroid.projecta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by David
 */
public class AthleteDataFeed {
    public static HashMap<String, List<String>> getInfo()
    {
        HashMap<String, List<String>> AthletesDetails = new HashMap<String, List<String>>();

        List<String> Track_Athletes = new ArrayList<String>();
        Track_Athletes.add("Jeremy Jennings   Age:23  Event:100m        PB: 10.47s");
        Track_Athletes.add("Parity Johnson    Age:20  Event:400m        PB: 47.44s");
        Track_Athletes.add("Peter Stevens     Age:19  Event:High Jump   PB:1.99m");
        Track_Athletes.add("Sarah Ferguson    Age:24  Event:Javelin     PB:59.78m");
        Track_Athletes.add("Susan Author      Age:21  Event:Long Jump   PB:6.34m");

        List<String> CrossCountry_Athletes = new ArrayList<String>();
        CrossCountry_Athletes.add("Daisy Peters     Age:18  Event:4km       PB:15:45s");
        CrossCountry_Athletes.add("John Terry       Age:23  Event:12km      PB:40:23s");
        CrossCountry_Athletes.add("Wayne Gerrard    Age:21  Event:4km       PB:13:03s");
        CrossCountry_Athletes.add("Angel Rooney     Age:19  Event:8km       PB:25:49s");
        CrossCountry_Athletes.add("Jason Fletcher   Age:32  Event:12km      PB:37:43s");

        List<String> RoadRunner_Athletes= new ArrayList<String>();
        RoadRunner_Athletes.add("Kevin Jones        Age:21  Event:21.1km    PB:1:03:45");
        RoadRunner_Athletes.add("Chris Ferdinand    Age:19  Event:10km      PB:32:00");
        RoadRunner_Athletes.add("James Green        Age:24  Event:42km      PB:2:17:53");
        RoadRunner_Athletes.add("Lucas Barkley      Age:29  Event:42km      PB:2:13:42");
        RoadRunner_Athletes.add("Tony Austins       Age:22  Event:5km       PB:14:21");

        List<String> TriAthlon_Athletes = new ArrayList<String>();
        TriAthlon_Athletes.add("Jimmy Force         Age:32  PB:1:32:45");
        TriAthlon_Athletes.add("Sidney Dre          Age:28  PB:1:22:00");
        TriAthlon_Athletes.add("Kate Williams       Age:37  PB:1:20:07");
        TriAthlon_Athletes.add("Venus Williamson    Age:27  PB:1:30:26");
        TriAthlon_Athletes.add("Trevor Philips      Age:26  PB:1:40:32");

        AthletesDetails.put("Track Athletes", Track_Athletes);
        AthletesDetails.put("Cross-Country Athletes", CrossCountry_Athletes);
        AthletesDetails.put("Road Athletes", RoadRunner_Athletes);
        AthletesDetails.put("Tri-Athletes", TriAthlon_Athletes);

        return AthletesDetails;

    }


}
