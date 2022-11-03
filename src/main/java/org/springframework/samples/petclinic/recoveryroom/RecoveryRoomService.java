package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RecoveryRoomService {
	
	@Autowired
	RecoveryRoomRepository recoveryRoomRepo;
	
	
    public List<RecoveryRoom> getAll(){
        return recoveryRoomRepo.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return null;
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return recoveryRoomRepo.getRecoveryRoomType(typeName);
    }

    @Transactional
    public RecoveryRoom save(RecoveryRoom p) throws DuplicatedRoomNameException {
    	RecoveryRoom r=recoveryRoomRepo.getRecoveryRoom(p.getName());
    	if(r==null || r.getName()!=p.getName() || r.getRoomType()!=p.getRoomType()) {
    		return recoveryRoomRepo.save(p);
    	}else {
    		throw new DuplicatedRoomNameException();
    	}
    }

    
}
