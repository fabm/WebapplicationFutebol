/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pac;

import eu.dataaccess.footballpool.TTopGoalScorer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author cfiute
 */
@Stateless
public class Marcador implements Iterator<Marcador> {

    private Iterator<Marcador> iterador = null;
    private ArrayList<Marcador> lista = null;
    private Marcador atual;
    private String jogador;
    private int golos;

    public void setQtdJogadores(int qtdJogadores) {
        if (lista == null ||
                lista.size() != qtdJogadores) {
            List<TTopGoalScorer> listaGoalScorer =
                    Futebol.topGoalScorers(qtdJogadores).
                    getTTopGoalScorer();
            lista = new ArrayList<>(qtdJogadores);

            for (TTopGoalScorer tTopGoalScorer : listaGoalScorer) {
                Marcador marcador = new Marcador();
                marcador.jogador = tTopGoalScorer.getSName();
                marcador.golos = tTopGoalScorer.getIGoals();
                lista.add(marcador);
            }
            iterador = lista.iterator();
            return;
        }
        iterador = lista.iterator();
    }

    public int getGolos() {
        return atual.golos;
    }

    public String getJogador() {
        return atual.jogador;
    }

    @Override
    public boolean hasNext() {
        return iterador.hasNext();
    }

    @Override
    public Marcador next() {
        atual = iterador.next();
        return null;
    }

    @Override
    public void remove() {
    }
}
