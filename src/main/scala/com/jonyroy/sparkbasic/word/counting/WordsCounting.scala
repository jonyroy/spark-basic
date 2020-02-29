package com.jonyroy.sparkbasic.word.counting

import com.jonyroy.sparkbasic.utils.DataDirectory
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

object WordsCounting {

  def countUniqueWords(implicit sparkSession: SparkSession): Long = getWordsCountRDD.count()

  def getWordsCountRDD(implicit sparkSession: SparkSession): RDD[(String, Int)] = {

    sparkSession
      .sparkContext
      .textFile(inputPath)
      .flatMap(line => line.split(' '))
      .map(word => (word.toLowerCase, 1))
      .reduceByKey(_ + _)
  }

  private def inputPath: String = DataDirectory.getDataDir + "WordsCounting" + "/*"

  def getMostFrequentWords(numOfFrequentWords: Int = 1)(
    implicit sparkSession: SparkSession): List[(String, Int)] = {

    getWordsCountRDD
      .sortBy(_._2, false)
      .take(numOfFrequentWords)
      .toList
  }

  private def apply()(implicit sparkSession: SparkSession): Long = countWords()

  def countWords()(implicit sparkSession: SparkSession): Long = {

    getWordsCountRDD
      .map(_._2)
      .sum()
      .toLong
  }

}
