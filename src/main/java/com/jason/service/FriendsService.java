package com.jason.service;

import com.github.pagehelper.PageInfo;
import com.jason.model.entity.Friends;

import java.util.List;

public interface FriendsService {

    public void addFriends(Friends friends);

    public void updateFriends(Friends friends);

    public void deleteFriends(Integer id);

    public PageInfo<Friends> getAllFriends(Integer page, Integer size);

    public Friends getOneFriendsById(Integer id);

    public List<Friends> getFriends();
}
