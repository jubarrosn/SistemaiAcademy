package br.com.iacademy.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Pagamento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pagm_iden;
	
	private float pagm_valor;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String pagm_data;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String pagm_data_venc;

	public long getPagm_iden() {
		return pagm_iden;
	}

	public void setPagm_iden(long pagm_iden) {
		this.pagm_iden = pagm_iden;
	}

	public float getPagm_valor() {
		return pagm_valor;
	}

	public void setPagm_valor(float pagm_valor) {
		this.pagm_valor = pagm_valor;
	}

	public String getPagm_data() {
		return pagm_data;
	}

	public void setPagm_data(String pagm_data) {
		this.pagm_data = pagm_data;
	}

	public String getPagm_data_venc() {
		return pagm_data_venc;
	}

	public void setPagm_data_venc(String pagm_data_venc) {
		this.pagm_data_venc = pagm_data_venc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pagm_data == null) ? 0 : pagm_data.hashCode());
		result = prime * result + ((pagm_data_venc == null) ? 0 : pagm_data_venc.hashCode());
		result = prime * result + (int) (pagm_iden ^ (pagm_iden >>> 32));
		result = prime * result + Float.floatToIntBits(pagm_valor);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (pagm_data == null) {
			if (other.pagm_data != null)
				return false;
		} else if (!pagm_data.equals(other.pagm_data))
			return false;
		if (pagm_data_venc == null) {
			if (other.pagm_data_venc != null)
				return false;
		} else if (!pagm_data_venc.equals(other.pagm_data_venc))
			return false;
		if (pagm_iden != other.pagm_iden)
			return false;
		if (Float.floatToIntBits(pagm_valor) != Float.floatToIntBits(other.pagm_valor))
			return false;
		return true;
	}

	public Pagamento() {
		super();
	}

	public Pagamento(long pagm_iden, float pagm_valor, String pagm_data, String pagm_data_venc) {
		super();
		this.pagm_iden = pagm_iden;
		this.pagm_valor = pagm_valor;
		this.pagm_data = pagm_data;
		this.pagm_data_venc = pagm_data_venc;
	}

	@Override
	public String toString() {
		return "Pagamento [pagm_iden=" + pagm_iden + ", pagm_valor=" + pagm_valor + ", pagm_data=" + pagm_data
				+ ", pagm_data_venc=" + pagm_data_venc + "]";
	}
	
}