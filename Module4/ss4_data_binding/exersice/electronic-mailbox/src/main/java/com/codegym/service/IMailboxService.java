package com.codegym.service;

import com.codegym.model.Mailbox;

import java.time.LocalDate;
import java.util.List;

public interface IMailboxService {
    List<Mailbox> show();
    Mailbox showById(int id);
    void update(Mailbox mailbox);

}
