package com.jason.dao;

import com.jason.model.entity.Friends;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FriendsDao {

    public void addFridens(Friends friends);

    public void updateFriends(Friends friends);

    public void deleteFriends(@Param("id") Integer id);

    public List<Friends> getAllFriends();

    public Friends getOneFriendById(@Param("id") Integer id);
}
