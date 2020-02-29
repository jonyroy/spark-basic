package com.jonyroy.sparkbasic

import org.apache.spark.sql.SparkSession

trait SparkSessionObj {
  val sparkSession: SparkSession = SparkSession
    .builder()
    .appName("spark-basic")
    .master("local[*]")
    .getOrCreate()
}
