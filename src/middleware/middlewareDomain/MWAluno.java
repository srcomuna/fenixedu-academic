// Generated by impart OJB Generator
// www.impart.ch matthias.roth@impart.ch
// created at 18 Sep 2003 13:25:08 GMT

package middleware.middlewareDomain;

import java.util.List;


public class MWAluno  
{

  private String istuniversity;
  private String answer1;
  private String answer2;
  private String answer3;
  private String answer4;
  private String answer5;
  private String answer6;
  private String answer7;
  private Integer branchcode;
  private Integer degreecode;
  private String documentidnumber;
  private String gratuitysituation;
  private Integer number;
  private String trash;
  private String worker;
  private Integer year;
  private List enrolments; 


  private MWPessoa middlewarePerson;


  public String getIstuniversity()
  {
     return this.istuniversity;
  }
  public void setIstuniversity(String param)
  {
    this.istuniversity = param;
  }


  public String getAnswer1()
  {
     return this.answer1;
  }
  public void setAnswer1(String param)
  {
    this.answer1 = param;
  }


  public String getAnswer2()
  {
     return this.answer2;
  }
  public void setAnswer2(String param)
  {
    this.answer2 = param;
  }


  public String getAnswer3()
  {
     return this.answer3;
  }
  public void setAnswer3(String param)
  {
    this.answer3 = param;
  }


  public String getAnswer4()
  {
     return this.answer4;
  }
  public void setAnswer4(String param)
  {
    this.answer4 = param;
  }


  public String getAnswer5()
  {
     return this.answer5;
  }
  public void setAnswer5(String param)
  {
    this.answer5 = param;
  }


  public String getAnswer6()
  {
     return this.answer6;
  }
  public void setAnswer6(String param)
  {
    this.answer6 = param;
  }


  public String getAnswer7()
  {
     return this.answer7;
  }
  public void setAnswer7(String param)
  {
    this.answer7 = param;
  }


  public Integer getBranchcode()
  {
     return this.branchcode;
  }
  public void setBranchcode(Integer param)
  {
    this.branchcode = param;
  }


  public Integer getDegreecode()
  {
     return this.degreecode;
  }
  public void setDegreecode(Integer param)
  {
    this.degreecode = param;
  }


  public String getDocumentidnumber()
  {
     return this.documentidnumber;
  }
  public void setDocumentidnumber(String param)
  {
    this.documentidnumber = param;
  }


  public String getGratuitysituation()
  {
     return this.gratuitysituation;
  }
  public void setGratuitysituation(String param)
  {
    this.gratuitysituation = param;
  }


  public Integer getNumber()
  {
     return this.number;
  }
  public void setNumber(Integer param)
  {
    this.number = param;
  }


  public String getTrash()
  {
     return this.trash;
  }
  public void setTrash(String param)
  {
    this.trash = param;
  }


  public String getWorker()
  {
     return this.worker;
  }
  public void setWorker(String param)
  {
    this.worker = param;
  }


  public Integer getYear()
  {
     return this.year;
  }
  public void setYear(Integer param)
  {
    this.year = param;
  }


  public String toString(){
    return  " [ISTUniversity] " + istuniversity + " [answer1] " + answer1 + " [answer2] " + answer2 + " [answer3] " + answer3 + " [answer4] " + answer4 + " [answer5] " + answer5 + " [answer6] " + answer6 + " [answer7] " + answer7 + " [branchCode] " + branchcode + " [degreeCode] " + degreecode + " [documentIdNumber] " + documentidnumber + " [gratuitySituation] " + gratuitysituation + " [studentNumber] " + number + " [trash] " + trash + " [worker] " + worker + " [year] " + year;

  }
  
	/**
	 * @return
	 */
	public MWPessoa getMiddlewarePerson() {
		return middlewarePerson;
	}
	
	/**
	 * @param middlewarePerson
	 */
	public void setMiddlewarePerson(MWPessoa oldPerson) {
		this.middlewarePerson = oldPerson;
	}

	/**
	 * @return
	 */
	public List getEnrolments() {
		return enrolments;
	}
	
	/**
	 * @param enrolments
	 */
	public void setEnrolments(List enrolments) {
		this.enrolments = enrolments;
	}

}
