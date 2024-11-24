package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;


@RunWith(MockitoJUnitRunner.class)

public class CatTest {

    @Mock
    Feline feline;


    @Test
    public void testGetSound() {
        Cat cat = new Cat(feline);
        String expectedSound = "Мяу";
        Assert.assertEquals("Неверный звук", expectedSound, cat.getSound());
    }

    @Test
    public void testSetSound() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedFood = List.of("Мясо");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
        Assert.assertEquals("Неверный список еды", expectedFood, cat.getFood());
    }
}
