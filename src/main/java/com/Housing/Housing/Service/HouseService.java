package com.Housing.Housing.Service;

import com.Housing.Housing.Entity.House;
import com.Housing.Housing.repository.Houserepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {
    @Autowired

    Houserepository houserepository;

    public int Averagesaleprice() {
        return houserepository.avgAllSell();
    }

    public void adddata(List<House> data) {
        houserepository.saveAll(data);
    }


    public List<Object> AverageByLocation() {
       return houserepository.aveloction();
    }
    public List<Object> maxsaleprice() {
        return houserepository.maxsaleprice();
    }

    public List<Object> minsaleprice() {
        return houserepository.minsaleprice();
    }


}
