package isdb.courseback.service;

import isdb.courseback.dto.MessageMinerDto;
import isdb.courseback.dto.MinerPartResponse;
import isdb.courseback.model.BrigadeRecord;
import isdb.courseback.model.MessageMiner;
import isdb.courseback.model.Miner;
import isdb.courseback.repository.BrigadeRecordRepository;
import isdb.courseback.repository.MinerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagingService {

    private MinerRepository minerRepository;
    private BrigadeRecordRepository brigadeRecordRepository;
    private MessageMinerService messageMinerService;


    @Autowired
    public ManagingService(MinerRepository minerRepository,  BrigadeRecordRepository brigadeRecordRepository,
                           MessageMinerService messageMinerService){
        this.minerRepository = minerRepository;
        this.brigadeRecordRepository = brigadeRecordRepository;
        this.messageMinerService = messageMinerService;
    }

    public List<MinerPartResponse> showManagingByBrigadeId(int brigadeId) {

        List<BrigadeRecord> brigadeRecords = brigadeRecordRepository.findAllByBrigadeId(brigadeId);
        System.out.println("================================================================================");
        System.out.println(brigadeRecords);
        System.out.println("================================================================================");

        List<MinerPartResponse> minerDeliveryResponseList = new ArrayList<MinerPartResponse>();
        for (BrigadeRecord brigadeRec:
                brigadeRecords)
        {
            minerDeliveryResponseList.add(MinerPartResponse.builder()
                    .minerId(brigadeRec.getMinerId())
                    .name(minerRepository.findNameByMinerId(brigadeRec.getMinerId()))
                    .part(brigadeRec.getPart())
                    .build());
        }
        return minerDeliveryResponseList;
    }

    public List<Miner> showMiners(){
        System.out.println("??????????????????????????????????????");
        System.out.println(minerRepository.showMiners());
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        return minerRepository.showMiners();
    }


    public BrigadeRecord addBrigadeRecord(BrigadeRecord brigadeRecord){
        brigadeRecord.setBrigadeId(brigadeRecord.getBrigadeId());
        brigadeRecord.setMinerId(brigadeRecord.getMinerId());
        brigadeRecord.setPart(brigadeRecord.getPart());
        brigadeRecordRepository.save(brigadeRecord);
        return brigadeRecord;
    }

    public void deleteBrigadeRecord(int minerId){
        messageMinerService.addMessage(new MessageMinerDto(minerId, "ERROR", "Вас удалили из бригады"));
        brigadeRecordRepository.deleteByMinerId(minerId);
    }


}
