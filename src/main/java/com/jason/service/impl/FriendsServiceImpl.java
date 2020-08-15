package com.jason.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jason.dao.FriendsDao;
import com.jason.model.entity.Friends;
import com.jason.service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendsServiceImpl implements FriendsService {
    @Autowired
    private FriendsDao friendsDao;

    @Override
    public void addFriends(Friends friends) {
        friendsDao.addFridens(friends);
    }

    @Override
    public void updateFriends(Friends friends) {
        friendsDao.updateFriends(friends);
    }

    @Override
    public void deleteFriends(Integer id) {
        friendsDao.deleteFriends(id);
    }

    @Override
    public PageInfo<Friends> getAllFriends(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Friends> friends = friendsDao.getAllFriends();
        return new PageInfo<>(friends);
    }

    @Override
    public Friends getOneFriendsById(Integer id) {
        return friendsDao.getOneFriendById(id);
    }

    @Override
    public List<Friends> getFriends() {
        return friendsDao.getAllFriends();
    }
}
