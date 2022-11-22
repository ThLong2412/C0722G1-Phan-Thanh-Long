package com.codegym.service.impl;

import com.codegym.model.Mailbox;
import com.codegym.service.IMailboxService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class MailboxService implements IMailboxService {
    private static List<Mailbox> mailboxList = new ArrayList<>();
    static {
        mailboxList.add(new Mailbox(1,"English",25,true,"Hello! I'm Long"));
        mailboxList.add(new Mailbox(2,"Japanese",10,false,"Hello! I'm Nam"));
    }

    @Override
    public List<Mailbox> show() {
        return mailboxList;
    }
    @Override
    public Mailbox showById(int id) {
        return mailboxList.get(findIndexId(id));
    }

    public int findIndexId(int id) {
        for (int i = 0; i < mailboxList.size(); i++) {
            if(mailboxList.get(i).getId() == id) {
                return i;
            }
        }
        return  -1;
    }
    @Override
    public void update(Mailbox mailbox) {
        int i = findIndexId(mailbox.getId());
        mailboxList.set(i, mailbox);
    }


}
