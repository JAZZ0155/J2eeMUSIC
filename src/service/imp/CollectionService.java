package service.imp;

import java.util.List;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import domain.Collection;
import domain.Post;
import domain.User;
import service.inter.CollectionServiceInter;

@Transactional
public class CollectionService extends BasicServiceAdapter implements CollectionServiceInter {

	@Override
	public Collection getById(int i) {
		// TODO Auto-generated method stub
		return (Collection) sessionFactory.getCurrentSession().get(Collection.class, i);
	}
	
	public Collection getByUserPost(int userId,int  postId) {
		String hql="from Collection where userId="+userId+" and postId="+postId;
		Collection c=(Collection) sessionFactory.getCurrentSession().createQuery(hql).list().get(0);
		return c;
	}

	@Override
	public List<Collection> getByUserId(int userId) {
		// TODO Auto-generated method stub
		String hql="from Collection where user.id=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, userId);
		return query.list();
	}
}
