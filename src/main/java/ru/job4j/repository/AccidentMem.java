package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AccidentMem {
    private final Map<Integer, Accident> accidents = new ConcurrentHashMap<>();

    {
        accidents.putIfAbsent(1, new Accident(
                1, "Происшествие 1", "Авария с участием грузовика", "ул.Пушкина д.5"
        ));
        accidents.putIfAbsent(2, new Accident(
                2, "Происшествие 2", "Сбили человека", "ул.Ленина д.83"
        ));
        accidents.putIfAbsent(3, new Accident(
                3, "Происшествие 3", "Авария с участием велосипедиста", "ул.Кукушкина д.1"
        ));
    }

    public List<Accident> findAll() {
        return new ArrayList<>(accidents.values());
    }

    public Accident findById(int id) {
        return accidents.get(id);
    }
}
