package Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.entities.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

	List<ProgrammingLanguage> programmingLanguages;
	
	@Autowired
	public InMemoryProgrammingLanguageRepository() {
		programmingLanguages = new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(1,"Java"));
		programmingLanguages.add(new ProgrammingLanguage(2,"C++"));
		programmingLanguages.add(new ProgrammingLanguage(3,"C#"));
		programmingLanguages.add(new ProgrammingLanguage(4,"Go"));
		programmingLanguages.add(new ProgrammingLanguage(5,"php"));
	}
	
	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguages;
	}

	@Override
	public ProgrammingLanguage getById(int id)  {
	for(ProgrammingLanguage programmingLanguage : programmingLanguages) {
		if(programmingLanguage.getId() == id) {
			return programmingLanguage;
		}
	}
		throw null;
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		programmingLanguages.add(programmingLanguage);
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		ProgrammingLanguage updateProgrammingLanguage =getById(programmingLanguage.getId());
		updateProgrammingLanguage.setName(programmingLanguage.getName());
	}

	@Override
	public void delete(int id) {
		ProgrammingLanguage deleteProgrammingLanguage = getById(id);
        programmingLanguages.remove(deleteProgrammingLanguage);
	}

}
