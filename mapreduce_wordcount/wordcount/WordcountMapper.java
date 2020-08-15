package com.atticus.mr.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

// map�׶�
// KEYIN �������ݵ�key
// VALUEIN �������ݵ�value
// KEYOUT ������ݵ�key������
// VALUEOUT ������ݵ�value����
public class WordcountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

	Text k = new Text();
	IntWritable v = new IntWritable(1);
	
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		
		// 1 ��ȡһ��
		String line = value.toString();
		
		// 2 �и��
		String[] words = line.split(" ");
		
		// 3 ѭ��д��
		for (String word : words) {
			//Text k = new Text();
			k.set(word);
			//IntWritable v = new IntWritable();
			//v.set(1);
			
			context.write(k, v);
		}
	}
}
