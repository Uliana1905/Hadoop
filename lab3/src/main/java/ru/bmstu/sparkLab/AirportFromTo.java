package ru.bmstu.sparkLab;

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
    private static final String REPLACEABLE_COLON = "\"";
    private static final String REPLACEMENT_NULL = "";
    private static final String REQEX = ",";
    private static final int NUMBER_ORIGIN_AIRPORT_ID = 11;
    private static final int NUMBER_DEST_AIRPORT_ID = 14;

    public static void main ( String [] args){
        SparkConf conf = new SparkConf().setAppName("lab5");
        JavaSparkContext sc = new JavaSparkContext ( conf);

        JavaRDD<String> fileWithAirports = sc.textFile("IDandName.csv");
        JavaRDD<String> airports = fileWithAirports.map(s-> s.replaceAll(REPLACEABLE_COLON, REPLACEMENT_NULL)).filter(s-> !s.equals(FIRSTLINE));
        JavaRDD<String[]> id_and_airport = airports.map(s -> s.split(REQEX));
        JavaPairRDD<Integer, String> pairIdName = id_and_airport.mapToPair(s -> new Tuple2<>(parseInt(s[0]), s[1]));


        JavaRDD<String> fileWithFlight = sc.textFile("IDandTime.csv");
        JavaRDD<String> flights = fileWithFlight.map(s-> s.replaceAll(REPLACEABLE_COLON, REPLACEMENT_NULL)).filter(s -> !s.contains("YEAR"));
        JavaRDD<String[]> features_flight = flights.map(s -> s.split(REQEX));

        JavaPairRDD<Tuple2<Integer,Integer>, FlightSerializable> pairId_one_and_two = features_flight.mapToPair(s -> new Tuple2<>(new Tuple2<>(parseInt(s[NUMBER_ORIGIN_AIRPORT_ID]),parseInt(s[NUMBER_DEST_AIRPORT_ID])),new FlightSerializable(parseInt(s[NUMBER_ORIGIN_AIRPORT_ID]),parseInt(s[NUMBER_DEST_AIRPORT_ID]), parseInt(s[1]), parseInt(s[2]))));

    }
}
