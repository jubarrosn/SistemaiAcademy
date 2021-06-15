package br.com.iacademy.repository;

public interface Message<SeverityType> {
	
	String getText();

    SeverityType getSeverity();

}