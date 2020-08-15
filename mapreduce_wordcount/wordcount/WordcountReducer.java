package com.atticus.mr.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

// KEYIN, VALUEIN map�׶������key��value
public class WordcountReducer extends Reducer<Text, IntWritable, Text, IntWritable>{

	IntWritable v = new IntWritable();
	
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Context context) throws IOException, InterruptedException {
		
		
		int sum = 0;
		
		// 1 �ۼ����
		for (IntWritable value : values) {
			
			sum += value.get();
		}
		
		//IntWritable v = new IntWritable();
		
		v.set(sum);
		
		// 2 д��
		context.write(key, v);
	}
}
