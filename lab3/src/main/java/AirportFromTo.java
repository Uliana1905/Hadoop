import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.supercsv.cellprocessor.ParseInt;
import scala.Tuple2;

import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class AirportFromTo {
    private static final String FIRSTLINE = "Code,Description";
    private static final String REPLACEABLE = "\"";
    private static final String REPLACEMENT = "";
    private static final String REQEX = ",";

    public static void main ( String [] args){
        SparkConf conf = new SparkConf().setAppName("lab5");
        JavaSparkContext sc = new JavaSparkContext ( conf);

        JavaRDD<String> fileWithAirports = sc.textFile("IDandName.csv");

        JavaRDD<String> airports = fileWithAirports.map(s-> s.replaceAll(REPLACEABLE, REPLACEMENT)).filter(s-> !s.equals(FIRSTLINE));

        JavaRDD<String[]> id_and_airport = airports.map(s -> s.split(REQEX));

        JavaPairRDD<Integer, String> pairIdName = id_and_airport.mapToPair(s -> new Tuple2<>(parseInt(s[0]), s[1]));

        JavaRDD<String> fileWithFlight = sc.textFile("IDandName.csv");


    }
}
