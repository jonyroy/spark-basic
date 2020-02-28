package com.jonyroy.sparkbasic

import com.jonyroy.sparkbasic.word.counting.WordsCounting
import org.apache.spark.sql.SparkSession

object SparkBasic {

  def main(args: Array[String]): Unit = {

    implicit val sparkSession: SparkSession = SparkSession
      .builder()
      .appName("spark-basic")
      .master("local[*]")
      .getOrCreate()

    val count = WordsCounting()

    println(s"Total Words Count: ${count}")

    sparkSession.stop()

  }
}
