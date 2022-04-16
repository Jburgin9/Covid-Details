package com.example.kotlinapp

import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Test

class SampleTest {

    @Test
    internal fun `countries has only alpha chas`(){
        val testCountry = "12USA"
        assertEquals(testCountry, "USA")
    }

}