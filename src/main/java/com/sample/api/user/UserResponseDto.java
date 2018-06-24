package com.sample.api.user;

import java.util.List;

import com.sample.base.ResponseDto;
import com.sample.db.entity.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UserResponseDto extends ResponseDto {
	List<User> userList;
}
