package com.neuedu.utils.pojoTovo;

import com.github.pagehelper.PageInfo;
import com.neuedu.pojo.Employment;
import com.neuedu.vo.JobListVOClass;
import com.neuedu.vo.JobListVOClassDetil;
import com.neuedu.vo.JobListVOCompany;
import com.neuedu.vo.JobListVOCompanyDetil;

import java.text.DecimalFormat;

/**
 * @把po类转换成vo类的工具类
 */
public class PoToVoUtil {

    //转换就业数据vo类公司相关
    public static JobListVOCompany getNewCompany(String cname, double jobnum, double offernum, double avgMoney){
        JobListVOCompany jlvc = new JobListVOCompany();


        //公司名称
        jlvc.setC_name(cname);
        //总面试人数
        jlvc.setC_num(jobnum);
        //总offer人数
        jlvc.setC_offer(offernum);
        //通过比率
        String s = "";
        if(offernum == 0 || jobnum == 0){
            s = "0";
        }else{
            double f = (offernum/jobnum)*100;
            DecimalFormat df = new DecimalFormat("##.00");
            s = df.format(f)+"%";
        }
        jlvc.setC_success(s);
        //总平均薪资
        if(avgMoney == 0.00){
            avgMoney = 0;
        }
        jlvc.setC_money(avgMoney);

        return jlvc;
    }

    //转换就业数据vo类班级相关
    public static JobListVOClass getNewClass(Employment em){
        JobListVOClass jlvc = new JobListVOClass();
        return jlvc;
    }

    //转换就业数据详情vo类公司相关
    public static JobListVOCompanyDetil getNewCompanyDetil(PageInfo pi,
                                                           String cname, double jobnum, double offernum, double avgMoney){

        JobListVOCompanyDetil jlvc = new JobListVOCompanyDetil();
        //公司名称
        jlvc.setC_name(cname);
        //总面试人数
        jlvc.setC_num(jobnum);
        //总offer人数
        jlvc.setC_offer(offernum);
        //总入职人数

        //通过比率
        String s = "";
        if(offernum == 0 || jobnum == 0){
            s = "0";
        }else{
            double f = (offernum/jobnum)*100;
            DecimalFormat df = new DecimalFormat("##.00");
            s = df.format(f)+"%";
        }
        jlvc.setC_success(s);
        //总平均薪资
        if(avgMoney == 0.00){
            avgMoney = 0;
        }
        jlvc.setC_money(avgMoney);
        //详细信息
        jlvc.setPi(pi);

        return jlvc;
    }

    //转换就业数据vo类班级相关
    public static JobListVOClassDetil getNewClassDetil(Employment em){
        JobListVOClassDetil jlvc = new JobListVOClassDetil();
        return jlvc;
    }
}
