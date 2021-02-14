package isdb.courseback.service;

import isdb.courseback.dto.MessageMinerDto;
import isdb.courseback.model.MessageMiner;
import isdb.courseback.repository.MessageMinerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageMinerService {

    private MessageMinerRepository messageMinerRepository;

    @Autowired
    public MessageMinerService(MessageMinerRepository messageMinerRepository) {
        this.messageMinerRepository = messageMinerRepository;
    }

    public boolean addMessage(MessageMinerDto messageMinerDto) {
        MessageMiner messageMiner = new MessageMiner();
        messageMiner.setMinerId(messageMinerDto.getMinerId());
        messageMiner.setStatus(messageMinerDto.getStatus());
        messageMiner.setDescription(messageMinerDto.getDescription());

        try {
            this.messageMinerRepository.save(messageMiner);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public List<MessageMiner> showAllMinerMessages(int minerId) {
        return messageMinerRepository.findAllByMinerId(minerId);
    }

}
