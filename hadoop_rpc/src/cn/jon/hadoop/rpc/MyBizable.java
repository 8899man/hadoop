package cn.jon.hadoop.rpc;

public interface MyBizable {
	long versionID = 123456;//���ֶα���Ҫ�У���Ȼ�ᱨjava.lang.NoSuchFieldException: versionID�쳣
	public String doSomething(String str);
}
