package models;

import models.GroupUsers;
import models.GroupUsersRepository;
import models.User;
import models.UserRepository;
import play.mvc.Controller;
import play.mvc.Result;
import util.Common;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class GroupUsersADO {
    private  GroupUsersRepository groupUsersRepository;
    private  UserRepository userRepository;

    public GroupUsersADO(GroupUsersRepository groupUsersRepository,
    UserRepository userRepository) {
        this.groupUsersRepository = groupUsersRepository;
        this.userRepository = userRepository;
    }


    public GroupUsers createGroup(long userID, String groupName,
                            String groupDescription) {
        User user = userRepository.findOne(userID);
        List<User> groupMembers = new ArrayList<User>();
        groupMembers.add(user);

        GroupUsers group = new GroupUsers(userID, groupName, groupDescription, groupMembers);
        System.out.println("group is " + group);
        groupUsersRepository.save(group);

        return group;
    }


    public boolean addMembersToGroup(String groupUrl, long userId) {
        User user = userRepository.findOne(userId);
        List<GroupUsers> groups = groupUsersRepository.findByGroupUrl(groupUrl);
        if(groups.size() == 0){
            return false;
        }else{
            GroupUsers group = groups.get(0);
            group.getGroupMembers().add(user);
            groupUsersRepository.save(group);

            return true;
        }
    }


    public List<GroupUsers> getGroupList(Long userID, String format) {
        List<GroupUsers> groups = groupUsersRepository.findByUserId(userID);
        if(groups == null){
            return null;
        }
        for (GroupUsers group: groups) {
            for (int i=0; i<group.getGroupMembers().size(); i++) {
                Set<User> empty = new HashSet<>();
                group.getGroupMembers().get(i).setFollowers(empty);
                group.getGroupMembers().get(i).setFriends(empty);
            }
        }

        return groups;
    }


    public List<User> getGroupMembers(Long groupId, String format) {
        GroupUsers group = groupUsersRepository.findById(groupId);
        List<User> groupMembers = group.getGroupMembers();
        for(User groupMember: groupMembers) {
            groupMember.setPassword("******");
        }

        return groupMembers;
    }
}

