
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author xuant
 */
public class FuCached {
    private Object data;
    private Date expriredDate;

    public FuCached(Object data, int timeTolive) {
        this.data = data;
        this.expriredDate = new Date(new Date().getTime() + timeTolive);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Date getExpriredDate() {
        return expriredDate;
    }

    public void setExpriredDate(Date expriredDate) {
        this.expriredDate = expriredDate;
    }
    
    
}



