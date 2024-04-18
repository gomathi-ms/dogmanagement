package com.example.DMS.Model;

import jakarta.persistence.Id;

import jakarta.persistence.Entity;


@Entity
public class Trainer {
	@Id
	private int TrainerId;
	private String TrainerName;
	private String TrainerAddress;
	@Override
	public String toString() {
		return "Trainer [TrainerId=" + TrainerId + ", TrainerName=" + TrainerName + ", TrainerAddress=" + TrainerAddress
				+ "]";
	}
	public int getTrainerId() {
		return TrainerId;
	}
	public String getTrainerName() {
		return TrainerName;
	}
	public String getTrainerAddress() {
		return TrainerAddress;
	}
	public void setTrainerId(int trainerId) {
		TrainerId = trainerId;
	}
	public void setTrainerName(String trainerName) {
		TrainerName = trainerName;
	}
	public void setTrainerAddress(String trainerAddress) {
		TrainerAddress = trainerAddress;
	}

}
