#!/bin/bash
javac Main.java *.java
jar cfm jayapp.jar Manifest.txt Main.class *.class org/*
