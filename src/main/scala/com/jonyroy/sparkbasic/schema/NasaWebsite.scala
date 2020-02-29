package com.jonyroy.sparkbasic.schema


case class NasaWebsite(
                        requesting_host: String,
                        datetime: String,
                        request: String,
                        status: String,
                        response_size: String
                      )
