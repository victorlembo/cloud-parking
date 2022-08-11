package one.digitalinnovation.parking.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import one.digitalinnovation.parking.model.Parking;

@Service
public class ParkingService {

	private static Map<String, Parking> parkingMap = new HashMap();

	static {
		String id = getUUID();
		String id1 = getUUID();
		Parking parking = new Parking(id, "DMS-1111", "SC", "CELTA", "PRETO");
		Parking parking1 = new Parking(id1, "CMS-1111", "SP", "GOL", "VERMELHO");
		parkingMap.put(id, parking);
		parkingMap.put(id1, parking1);

	}

	public List<Parking> findAll() {
		return parkingMap.values().stream().collect(Collectors.toList());
	}

	private static String getUUID() {

		return UUID.randomUUID().toString().replace("-", "");

	}

	public Parking findById(String id) {
		// TODO Auto-generated method stub
		return parkingMap.get(id);
	}

	public Parking create(Parking parkingCreate) {

		String uuid = getUUID();

		parkingCreate.setId(uuid);
		parkingCreate.setEntryDate(LocalDateTime.now());
		parkingMap.put(uuid, parkingCreate);
		
		return parkingCreate;

	}
}
