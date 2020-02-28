package com.jonyroy.sparkbasic

import org.apache.spark.sql.SparkSession

object SparkBasic {

  def main(args: Array[String]): Unit = {

    val sparkSession: SparkSession = SparkSession
      .builder()
      .appName("spark-basic")
      .master("local[*]")
      .getOrCreate()

    println("Hello World Spark")

  }
}
