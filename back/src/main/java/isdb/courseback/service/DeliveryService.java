package isdb.courseback.service;

import isdb.courseback.model.Auto;
import isdb.courseback.model.Equipment;
import isdb.courseback.repository.AutoRepository;
import isdb.courseback.repository.DeliveryAutoRepository;
import isdb.courseback.repository.DeliveryEquipmentRepository;
import isdb.courseback.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceException;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    private EntityManager entityManager;
    private DeliveryEquipmentRepository deliveryEquipmentRepository;
    private DeliveryAutoRepository deliveryAutoRepository;
    private EquipmentRepository equipmentRepository;

    @Autowired
    public DeliveryService(EntityManager entityManager, DeliveryEquipmentRepository deliveryEquipmentRepository,
                           DeliveryAutoRepository deliveryAutoRepository, EquipmentRepository equipmentRepository)
    {
        this.entityManager = entityManager;
        this.deliveryEquipmentRepository = deliveryEquipmentRepository;
        this.deliveryAutoRepository = deliveryAutoRepository;
        this.equipmentRepository = equipmentRepository;
    }

    public String doDelivery(int minerId)    {
        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery("do_delivery_by_miner_id");
        query.registerStoredProcedureParameter("min_id", Integer.class, ParameterMode.IN);
        query.setParameter("min_id", minerId);

        try {
            query.execute();
        } catch (PersistenceException e) {
            Throwable rootException = e;
            while(rootException.getCause()!=null){
                rootException = rootException.getCause();
            }
            String reason = rootException.getLocalizedMessage();
            return reason.substring(reason.indexOf(":") + 2, reason.indexOf("\n"));
        }
        Optional<Integer> equipId = deliveryEquipmentRepository.findEquipIdByMinerId(minerId);

        if (equipId.isPresent()) {
            System.out.println(equipId.get());
            String equipmentName = equipmentRepository.findByEquipmentId(equipId.get()).map(Equipment::getName).orElse("");
            return "Оборудование [" + equipId.get() + "] " + equipmentName.charAt(0) + equipmentName.substring(1).toLowerCase() + " выдано";
        } else {
            Optional<Integer> autoId = deliveryAutoRepository.findAutoIdByMinerId(minerId);
            if (autoId.isPresent()) {
                return "Авто [" + autoId.get() + "] " + "выдано";
            }
        }

        return "";
    }

    public List<Equipment> findAllDeliveryEquipmentByBrigadeId(int brigadeId) {
        return null;
    }


}
