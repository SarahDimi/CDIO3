import java.util.Arrays;
package Main;

public class Player {
    String navn;
    SpilleBrik spilleBrik;
    Account account;
    Spiller[] spillere;
    int position;
    int antalSpiller;

    public Spiller(String navn, SpilleBrik spilleBrik, Account account, int antalSpiller){
        this.navn = navn;
        this.SpilleBrik = spilleBrik;
        this.Account = account;
        this.antalSpiller = antalSpiller;
    }

    public String getNavn(){
        return navn;
    }

    public void setNavn(String navn){
        this.navn = navn; 
    }

    public SpillerBrik getbrik(){
        return spilleBrik;
    }

    public Account getAccount(){
        return account;
    }

    public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

    public Spiller(int antalSpillere) {
		spillere = new Spiller[antalSpillere];
	}
	
	public void tilføjSpiller(Spiller spiller, int index) {
		spillere[index] = spiller;
	}

	public Spiller getSpiller(int index) {
		return spillere[index];
	}
	
	public int antalSpillere()
	{
		return spillere.length;
	}
	
	public void sorterEfterPenge() {
		
	}

	@Override
	public String toString() {
		return "Spillerliste: " + Arrays.toString(spillere);
	}
    
}
