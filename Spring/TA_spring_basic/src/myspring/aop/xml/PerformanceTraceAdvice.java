package myspring.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceTraceAdvice {
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		// Ÿ�� �޼ҵ��� signature ����
		String signatureString = joinPoint.getSignature().toShortString(); //�޼ҵ� �� �˱����� !
		System.out.println(signatureString + " ����");
		// Ÿ���� �޼ҵ尡 ȣ��Ǳ� ���� �ð�
		long start = System.currentTimeMillis();
		try {
			// Ÿ���� �޼ҵ� ȣ��
			Object result = joinPoint.proceed();
			return result;
		} finally {
			// Ÿ���� �޼��尡 ȣ��� ���� �ð�
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " ����");
			System.out.println(signatureString + " ����ð�: " + (finish - start) + " ms");

		}
	}

}
