
package com.rehber.controller;

import com.rehber.entity.Agac;
import com.rehber.entity.Cicek;
import com.rehber.entity.Hayvan;
import com.rehber.entity.Insan;
import com.rehber.entity.Kurulus;
import com.rehber.entity.NobetciEczaneler;
import com.rehber.entity.TaxiDuragi;
import com.rehber.fileOperations.FileOperations;

public class AddObject {
    
    
    
    public void Add(Object tmp)
    {
        if(tmp instanceof Insan)
        {
            FileOperations.getInstance().personAdd((Insan) tmp);
        }
        else if(tmp instanceof Hayvan)
        {
            FileOperations.getInstance().animalAdd((Hayvan)tmp);
        }
        else if(tmp instanceof Kurulus)
        {
            FileOperations.getInstance().companyAdd((Kurulus)tmp);
        }
        else if(tmp instanceof Cicek)
        {
            FileOperations.getInstance().flowerAdd((Cicek)tmp);
        }
        else if(tmp instanceof Agac)
        {
            FileOperations.getInstance().treeAdd((Agac)tmp);
        }
        else if(tmp instanceof NobetciEczaneler)
        {
            FileOperations.getInstance().pharmacyAdd((NobetciEczaneler)tmp);
        }
        else if(tmp instanceof TaxiDuragi)
        {
            FileOperations.getInstance().taxiAdd((TaxiDuragi)tmp);
        }
        
    }
    
}
