package com.jonyroy.sparkbasic.word.counting

import com.jonyroy.sparkbasic.SparkSessionObj
import com.jonyroy.sparkbasic.utils.DataDirectory
import org.apache.spark.rdd.RDD

object WordsCounting extends SparkSessionObj {

  def countUniqueWords: Long = getWordsCountRDD.count()

  def getWordsCountRDD: RDD[(String, Int)] = {

    sparkSession
      .sparkContext
      .textFile(inputPath)
      .flatMap(line => line.split(' '))
      .map(word => (word.toLowerCase, 1))
      .reduceByKey(_ + _)
  }

  private def inputPath: String = DataDirectory.getDataDir + "WordsCounting" + "/*"

  def getMostFrequentWords(numOfFrequentWords: Int = 1): List[(String, Int)] = {

    getWordsCountRDD
      .sortBy(_._2, false)
      .take(numOfFrequentWords)
      .toList
  }

  private def apply(): Long = countWords()

  def countWords(): Long = {

    getWordsCountRDD
      .map(_._2)
      .sum()
      .toLong
  }

}
