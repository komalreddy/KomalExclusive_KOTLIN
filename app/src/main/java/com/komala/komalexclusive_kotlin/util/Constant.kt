package com.komala.komalexclusive_kotlin.util

class Constant {
    // komal mail id
    //https://www.cricapi.com/member-test.aspx
     class Cricket{
         companion object{
             val URL_PREFIX_CRICKET : String = "https://cricapi.com/api/"
             val API_KEY_CRICKET : String = "xtHqJY7jB6PeJzpRycNnMmPqxfp1";
         }
     }

    // ballibalakrishna2334 & FirstCompany@btechrl
    //https://weatherstack.com/documentation
    //http://api.weatherstack.com/current?access_key=d292c9d0d539f743f7ccbc10e496cbd3&query=Hyderabad
    class Whether {
        companion object {
            var URL_PREFIX_WEATHER = "http://api.weatherstack.com/"
            var API_KEY_NEWS = "d292c9d0d539f743f7ccbc10e496cbd3"
        }
    }

}