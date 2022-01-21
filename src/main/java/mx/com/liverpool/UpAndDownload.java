package mx.com.liverpool;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;

import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.integration.sftp.session.SftpSession;

public class UpAndDownload {

	private DefaultSftpSessionFactory gimmeFactory() {
		DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory();
		factory.setHost("192.168.100.55");
		factory.setPort(22);
		factory.setAllowUnknownKeys(true);
		factory.setUser("gera");
		factory.setPassword("admin");
		return factory;
	}

	public void upload() {
		SftpSession session = gimmeFactory().getSession();
		InputStream resourceAsStream = UpAndDownload.class.getClassLoader().getResourceAsStream("mytextfile.txt");
		try {
			session.write(resourceAsStream, "/home/gera/Documentos/mynewfile" + LocalDateTime.now() + ".txt");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		session.close();
	}
}
