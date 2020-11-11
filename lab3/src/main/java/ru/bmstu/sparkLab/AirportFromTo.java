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
    private static final int NUMBER_CANCELLED = 19;
    private static final int NUMBER_ARR_DELAY = 18;

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

        JavaPairRDD<Tuple2<Integer,Integer>, FlightSerializable> pairId_one_and_two = features_flight.mapToPair(s -> new Tuple2<>(new Tuple2<>(parseInt(s[NUMBER_ORIGIN_AIRPORT_ID]),parseInt(s[NUMBER_DEST_AIRPORT_ID])),new FlightSerializable(parseInt(s[NUMBER_ARR_DELAY]), parseInt(s[NUMBER_CANCELLED]))));

        JavaPairRDD<Tuple2<Integer,Integer>, FlightSerializable> key_result = pairId_one_and_two.combineByKey(
                v -> new FlightSerializable(v.getArr_delay_new(), 1, v.getCancelled(), (v.getArr_delay_new() > (float)0)? 1:0),
                (v, element)-> new FlightSerializable((v.getArr_delay_new()< element.getArr_delay_new()) ? element.getArr_delay_new(): v.getArr_delay_new(), v.getNum_flight() + 1, (element.getNumCancelled() == (float)0)? v.getNumCancelled() :v.getNumCancelled() + 1, (element.getArr_delay_new() > 0)? v.getNum_dellay() +1: v.getNum_dellay()),
                (com1, com2)-> new FlightSerializable((com1.getArr_delay_new()< com2.getArr_delay_new()) ? com2.getArr_delay_new(): com1.getArr_delay_new(), com1.getNum_flight() + com2.getNum_flight(), com1.getNumCancelled() + com2.getNumCancelled(),com1.getNum_dellay() + com2.getNum_dellay()));

        JavaPairRDD<Map<Tuple2<Integer,Integer>, FlightSerializable>> key_resultAsMap = key_result.collectAsMap();



    }


}
