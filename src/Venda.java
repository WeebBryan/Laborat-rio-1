import java.util.ArrayList;
import java.util.List;

class Venda {
    private Aluno aluno;
    private List<CachorroQuente> cachorrosQuentes;

    public Venda(Aluno aluno) {
        this.aluno = aluno;
        this.cachorrosQuentes = new ArrayList<>();
    }

    public void adicionarCachorroQuente(CachorroQuente cachorroQuente) {
        cachorrosQuentes.add(cachorroQuente);
    }

    public Aluno getAluno() {
        return aluno;
    }

    public List<CachorroQuente> getCachorrosQuentes() {
        return cachorrosQuentes;
    }
}