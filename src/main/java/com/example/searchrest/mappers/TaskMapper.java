package com.example.searchrest.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.searchrest.domains.Task;

@Mapper
public interface TaskMapper {

	List<Task> all();

	void add(Task task);

	void complete(Task task);

}
