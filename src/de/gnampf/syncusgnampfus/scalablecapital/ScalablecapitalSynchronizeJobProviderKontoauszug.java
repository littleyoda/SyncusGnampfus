package de.gnampf.syncusgnampfus.scalablecapital;

import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.annotation.Resource;

import de.gnampf.syncusgnampfus.SyncusGnampfusSynchronizeJobProviderKontoauszug;
import de.willuhn.jameica.hbci.rmi.Konto;
import de.willuhn.jameica.hbci.synchronize.AbstractSynchronizeBackend;
import de.willuhn.jameica.hbci.synchronize.jobs.SynchronizeJob;

public class ScalablecapitalSynchronizeJobProviderKontoauszug extends SyncusGnampfusSynchronizeJobProviderKontoauszug 
{
	@Resource
	private ScalablecapitalSynchronizeBackend backend = null;

	@Override
	protected AbstractSynchronizeBackend<?> getBackend() { return backend; }

	public ScalablecapitalSynchronizeJobProviderKontoauszug()
	{
		JOBS = new ArrayList<Class<? extends SynchronizeJob>>()
		{{
			add(ScalablecapitalSynchronizeJobKontoauszug.class);
		}};
	}

	@Override
	public boolean supports(Class type, Konto k) 
	{
		return true;
		// try
		// {
		// 	return k.getBLZ().equals("20120700");
		// } 
		// catch (RemoteException e) 
		// {
		// 	return false;
		// }
	}
}
