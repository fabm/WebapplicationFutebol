/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pac;

import eu.dataaccess.footballpool.ArrayOftPlayerNames;
import eu.dataaccess.footballpool.ArrayOftStadiumInfo;
import eu.dataaccess.footballpool.ArrayOftTopGoalScorer;
import eu.dataaccess.footballpool.TPlayerNames;
import eu.dataaccess.footballpool.TStadiumInfo;
import eu.dataaccess.footballpool.TTopGoalScorer;
import java.util.List;

/**
 *
 * @author cfiute
 */
public class Futebol {
    
    private int nJogadores = 0;

    public void setnJogadores(int nJogadores) {
        this.nJogadores = nJogadores;
    }
    
    public List<TStadiumInfo> getListaEstadios(){
        return allStadiumInfo().getTStadiumInfo();
    }
    public List<TPlayerNames> getListaJogadores(){
        return allPlayerNames(true).getTPlayerNames();
    }
    public List<TTopGoalScorer> getListaMelhoresMarcadores(){
        return topGoalScorers(nJogadores).getTTopGoalScorer();
    }
    
    public static ArrayOftStadiumInfo allStadiumInfo() {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap();
        return port.allStadiumInfo();
    }

    public static ArrayOftTopGoalScorer topGoalScorers(int iTopN) {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap();
        return port.topGoalScorers(iTopN);
    }

    public static ArrayOftPlayerNames allPlayerNames(boolean bSelected) {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap();
        return port.allPlayerNames(bSelected);
    }
    
}
