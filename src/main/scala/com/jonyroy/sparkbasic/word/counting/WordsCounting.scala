package com.jonyroy.sparkbasic.word.counting

import com.jonyroy.sparkbasic.utils.DataDirectory
import org.apache.spark.sql.SparkSession

object WordsCounting {

  def apply()(implicit sparkSession: SparkSession): Long = wordsCounting()

  def wordsCounting()(implicit sparkSession: SparkSession): Long = {

    val inputPath = DataDirectory.getDataDir + "WordsCounting" + "/*"

    sparkSession
      .sparkContext
      .textFile(inputPath)
      .flatMap(line => line.split(' '))
      .map(word => (word, 1))
      .reduceByKey(_+_)
      .map(_._2)
      .sum()
      .toLong
  }

}
